var exec = require('cordova/exec');

exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "androidSpeech", "coolMethod", [arg0]);
};

exports.getSupportedLanguages = function(arg0, success, error) {
    exec(success, error, "androidSpeech", "getSupportedLanguages", [arg0]);
};

/**
 * Recognize speech and return a list of matches
 *
 * @param successCallback
 * @param errorCallback
 * @param reqCode User-defined integer request code which will be returned when recognition is complete
 * @param maxMatches The maximum number of matches to return. 0 means the service decides how many to return.
 * @param promptString An optional string to prompt the user during recognition
 */
exports.startRecognize = function(successCallback, errorCallback, maxMatches, promptString, language) {
    return cordova.exec(successCallback, errorCallback, "androidSpeech", "startRecognize", [maxMatches, promptString, language]);
};