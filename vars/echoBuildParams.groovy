/**
 * Dumps all parameters passed into a human readable pipeline message.
 *
 * Example:
 *
 *  echoBuildParams("someStep", someMap)
 *
 */
def call(String stepName, Map params) {

  def paramsString = params.collect{ "[Pipeline]   ${it.key.padRight(27)} => ${it.value.toString().padRight(75)} (${it.value.getClass()})" }.join("\n")

  echo """[Pipeline]
    [Pipeline] ${stepName} parameters
    [Pipeline]
    ${paramsString}
    [Pipeline]"""
}
