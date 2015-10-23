package cordova.android.speech.plugin;

import java.util.List;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import org.apache.cordova.*;

public class LanguageDetailsChecker extends BroadcastReceiver
{
    private List<String> supportedLanguages;
    private CallbackContext callbackContext;
    private CordovaWebView webView;

    public LanguageDetailsChecker(CallbackContext callbackContext, CordovaWebView webView) {
    	super();
        this.webView = webView;
    	this.callbackContext = callbackContext;
    }
    
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle results = getResultExtras(true);
        
		// get the list of supported languages
        if (results.containsKey(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES))
        {            
            // Convert the map to json
            supportedLanguages = results.getStringArrayList(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES);

            JSONArray jsonLanguages = new JSONArray(supportedLanguages);
            this.callbackContext.success(jsonLanguages);
        } else {
        	this.callbackContext.error("Could not retrieve the list of supported languages");
        }
	}
	
	public List<String> getSupportedLanguages(){
		return supportedLanguages;
	}
}