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

	dependencycheck additionalArguments: "--project ${projectname} --scan ./ --data /home/jenkins/security/owasp-nvd/ --out dependency-check-report.xml --format XML", odcInstallation: "DependencyCheck"
}

