/**
 * Use wildfly plugin to undeploy or deploy artifact..
 *
 * Example: 
 *
 * 	wildfly(deploymentType: "undeploy", jbossEnvironment: ${jbossEnvironmentGlobal})
 *
 **/
def call(Map params) {

	def deploymentType = params.deploymentType ?: ""

	if (isUnix()) {
    		sh "mvn wildfly:${deploymentType} -P " + params.jbossEnvironment
	} else {
    		bat "mvn wildfly:${deploymentType} -P " + params.jbossEnvironment
	}
}
