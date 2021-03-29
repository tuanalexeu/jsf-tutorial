package book.beans;

import java.util.logging.Logger;
import javax.faces.view.facelets.BehaviorHandler;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.ConverterHandler;
import javax.faces.view.facelets.TagHandlerDelegate;
import javax.faces.view.facelets.TagHandlerDelegateFactory;
import javax.faces.view.facelets.ValidatorHandler;

/**
 *
 * @author Leonard
 */
public class WelcomeTagHandlerDelegateFactory extends TagHandlerDelegateFactory {

    private static final Logger logger = Logger.getLogger(WelcomeTagHandlerDelegateFactory.class.getName());
    private TagHandlerDelegateFactory tagHandlerDelegateFactory;

    public WelcomeTagHandlerDelegateFactory() {
    }

    public WelcomeTagHandlerDelegateFactory(TagHandlerDelegateFactory tagHandlerDelegateFactory) {
        this.tagHandlerDelegateFactory = tagHandlerDelegateFactory;
    }

    @Override
    public TagHandlerDelegate createComponentHandlerDelegate(ComponentHandler owner) {
        logger.info("Inside 'TagHandlerDelegateFactory.createComponentHandlerDelegate' method");
        return new WelcomeTagHandlerDelegate(tagHandlerDelegateFactory.createComponentHandlerDelegate(owner));
    }

    @Override
    public TagHandlerDelegate createValidatorHandlerDelegate(ValidatorHandler owner) {
        logger.info("Inside 'TagHandlerDelegateFactory.createValidatorHandlerDelegate' method");
        return tagHandlerDelegateFactory.createValidatorHandlerDelegate(owner);
    }

    @Override
    public TagHandlerDelegate createConverterHandlerDelegate(ConverterHandler owner) {
        logger.info("Inside 'TagHandlerDelegateFactory.createConverterHandlerDelegate' method");
        return tagHandlerDelegateFactory.createConverterHandlerDelegate(owner);
    }

    @Override
    public TagHandlerDelegate createBehaviorHandlerDelegate(BehaviorHandler owner) {
        logger.info("Inside 'TagHandlerDelegateFactory.createBehaviorHandlerDelegate' method");
        return tagHandlerDelegateFactory.createBehaviorHandlerDelegate(owner);
    }
}
