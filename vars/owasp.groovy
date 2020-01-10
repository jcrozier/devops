/**
 * Use owasp dependency checker to find vulnerabilities .
 *
 * Example: 
 *
 * 		owasp(datadir: "/usr/share/nvd", autoUpdate: "false")
 *
 **/
def call(Map params) {

    	def dataDir = params.dataDir ?: ""
	def autoUpdate = params.autoUpdate ?: ""
	def projectname = params.projectname ?: ""
	//sh 'mvn org.owasp:dependency-check-maven:check -Dformat=XML -DdataDirectory=${dataDir} -DautoUpdate=${autoUpdate}'
	//	      step([$class: 'DependencyCheckPublisher', unstableTotalAll: '0'])

	sh(‘mkdir -p build/owasp’)
	dependencycheck additionalArguments: "--project ${projectname} --scan ./ --data /home/jenkins/security/owasp-nvd/ --out build/owasp/dependency-check-report.xml --format XML", odcInstallation: "DependencyCheck"
}
