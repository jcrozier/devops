/**
 * Use owasp dependency checker to find vulnerabilities .
 *
 * Example: 
 *
 * 		owasp(datadir: "/usr/share/nvd", autoUpdate: "false")
 *
 **/
def call(Map params) {

	sh 'mvn org.owasp:dependency-check-maven:check -Dformat=XML -DdataDirectory=${dataDir} -DautoUpdate=${autoUpdate}'
		      step([$class: 'DependencyCheckPublisher', unstableTotalAll: '0'])
}