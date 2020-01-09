/**
 * Set the version dependency for domain and service provider.
 *
 * Example: 
 *
 * 		serviceDependency (version: "use-latest-releases")
 *
 **/
def call(Map params) {

	sh 'mvn  -DgenerateBackupPoms=false -U versions:${version} -Dincludes=ie.bil.lifeandpensions:domain'
	sh 'mvn  -DgenerateBackupPoms=false -U versions:${version} -Dincludes=ie.bil.lifeandpensions:service-providers'
}