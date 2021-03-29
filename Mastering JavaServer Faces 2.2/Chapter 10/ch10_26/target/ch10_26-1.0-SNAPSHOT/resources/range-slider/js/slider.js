var rangeslider = {
    init: function(clientId, min, max, leftside, rightside) {
        var rangeval = (clientId + ":rangeval").replace(/:/g, "\\:");
        var slider = (clientId + ":slider").replace(/:/g, "\\:");
        $('#' + slider).slider({
            range: true,
            min: min,
            max: max,
            values: [parseInt(leftside), parseInt(rightside)],
            slide: function(event, ui) {
                $('#' + rangeval).html(ui.values[0] + " - " + ui.values[1]);
                $("#" + (clientId + ":leftsideId").replace(/:/g, "\\:")).val(ui.values[0]);
                $("#" + (clientId + ":rightsideId").replace(/:/g, "\\:")).val(ui.values[1]);
            }
        });
    }
};

