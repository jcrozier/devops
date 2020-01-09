/**
 * Deploy artefact to nexus artefact repository .
 *
 * Example: 
 *
 * 		nexusDeloy(nexusurl: ${nexusUrl})
 *
 **/
def call(Map params) {

	bat 'mvn clean deploy -Dmaven.test.skip -DaltDeploymentRepository=nexus::default::' + params.nexusUrl
}