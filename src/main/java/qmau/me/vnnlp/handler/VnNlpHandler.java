package qmau.me.vnnlp.handler;

import org.json.simple.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import vnnlp.core.RDRsegmenter;

public class VnNlpHandler implements RequestHandler<JSONObject, String> {

    public String handleRequest(JSONObject input, Context context) {
        context.getLogger().log("Input: " + input + "\n");
        String text = (String) input.get("text");
        String result = new String();
        try {
            RDRsegmenter segmenter = new RDRsegmenter();
            result = segmenter.segmentRawString(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
