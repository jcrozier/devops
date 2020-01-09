/**
 * Use wildfly plugin to undeploy or deploy artifact..
 *
 * Example: 
 *
 * 	wildfly(deploymentType: "undeploy", jbossEnvironment: ${jbossEnvironmentGlobal})
 *
 **/
def call(Map params) {

	bat 'mvn wildfly:${deploymentType} -P ' + params.jbossEnvironment
}