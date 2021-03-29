package book.beans;

import com.sun.faces.renderkit.ClientSideStateHelper;
import com.sun.faces.util.Util;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.ResponseStateManager;
import static com.sun.faces.config.WebConfiguration.BooleanWebContextInitParameter.EnableViewStateIdRendering;
import static com.sun.faces.config.WebConfiguration.BooleanWebContextInitParameter.AutoCompleteOffOnViewState;
import java.io.Writer;

/**
 *
 * @author Leonard
 */
public class CustomClientSideStateHelper extends ClientSideStateHelper {

    public CustomClientSideStateHelper() {
        super();
    }

    @Override
    public Object getState(FacesContext ctx, String viewId) throws IOException {

        String stateString = ClientSideStateHelper.getStateParamValue(ctx);

        if (stateString == null) {
            return null;
        }

        if ("stateless".equals(stateString)) {
            return "stateless";
        } else {
            WriteStateInDB writeStateInDB = new WriteStateInDB();
            stateString = writeStateInDB.readStateDB(stateString);
            if (stateString == null) {
                return null;
            }
        }

        return doGetState(stateString);
    }

    @Override
    public void writeState(FacesContext ctx,
            Object state,
            StringBuilder stateCapture) throws IOException {

        if (stateCapture != null) {
            doWriteState(ctx, state, new StringBuilderWriter(stateCapture));
        } else {
            ResponseWriter writer = ctx.getResponseWriter();

            writer.startElement("input", null);
            writer.writeAttribute("type", "hidden", null);
            writer.writeAttribute("name", ResponseStateManager.VIEW_STATE_PARAM, null);
            if (webConfig.isOptionEnabled(EnableViewStateIdRendering)) {
                String viewStateId = Util.getViewStateId(ctx);
                writer.writeAttribute("id", viewStateId, null);
            }
            StringBuilder stateBuilder = new StringBuilder();
            doWriteState(ctx, state, new StringBuilderWriter(stateBuilder));

            WriteStateInDB writeStateInDB = new WriteStateInDB();
            String client_id = writeStateInDB.writeStateDB(stateBuilder.toString());

            if (client_id != null) {
                writer.writeAttribute("value", client_id, null);
            } else {
                writer.writeAttribute("value", stateBuilder.toString(), null);
            }
            if (webConfig.isOptionEnabled(AutoCompleteOffOnViewState)) {
                writer.writeAttribute("autocomplete", "off", null);
            }
            writer.endElement("input");

            writeClientWindowField(ctx, writer);
            writeRenderKitIdField(ctx, writer);
        }
    }

    @Override
    protected Object doGetState(String stateString) {
        return super.doGetState(stateString);
    }

    @Override
    protected void doWriteState(FacesContext facesContext, Object state, Writer writer) throws IOException {
        super.doWriteState(facesContext, state, writer);
    }

    @Override
    protected boolean hasStateExpired(long stateTime) {
        return super.hasStateExpired(stateTime);
    }

    @Override
    public boolean isStateless(FacesContext facesContext, String viewId) throws IllegalStateException {
        return super.isStateless(facesContext, viewId);
    }

    /**
     * A simple
     * <code>Writer</code> implementation to encapsulate a
     * <code>StringBuilder</code> instance.
     */
    protected static final class StringBuilderWriter extends Writer {

        private StringBuilder sb;

        // -------------------------------------------------------- Constructors
        protected StringBuilderWriter(StringBuilder sb) {

            this.sb = sb;

        }

        // ------------------------------------------------- Methods from Writer
        @Override
        public void write(int c) throws IOException {

            sb.append((char) c);

        }

        @Override
        public void write(char cbuf[]) throws IOException {

            sb.append(cbuf);

        }

        @Override
        public void write(String str) throws IOException {

            sb.append(str);

        }

        @Override
        public void write(String str, int off, int len) throws IOException {

            sb.append(str.toCharArray(), off, len);

        }

        @Override
        public Writer append(CharSequence csq) throws IOException {

            sb.append(csq);
            return this;

        }

        @Override
        public Writer append(CharSequence csq, int start, int end)
                throws IOException {

            sb.append(csq, start, end);
            return this;

        }

        @Override
        public Writer append(char c) throws IOException {

            sb.append(c);
            return this;

        }

        @Override
        public void write(char cbuf[], int off, int len) throws IOException {

            sb.append(cbuf, off, len);

        }

        @Override
        public void flush() throws IOException {
            //no-op
        }

        @Override
        public void close() throws IOException {
            //no-op
        }
    } // END StringBuilderWriter
}
