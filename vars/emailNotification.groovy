/**
 * Send email with build status.
 *
 * Example: 
 *
 * 	emailNotifcation (jobBuildStatus: "Failed", jobName: ${env.JOB_NAME}. jobBuildNumber: ${env.BUILD_NUMBER}, jobBuildUrl: ${env.BUILD_URL}, emailList: "devEmail" )

 *
 **/
def call(Map params) {

	emailext (
		subject: "${jobBuildStatus}: Build ${jobBuildStatus} - Job '${jobName} [${jobBuildNumber}]'",
		body: """<p>${jobBuildStatus}: Build ${jobBuildStatus} - Job '${jobName} [${jobBuildNumber}]':</p>
	    	<p>Check console output at &QUOT;<a href='${jobBuildUrl}'>${jobName} [${jobBuildNumber}]</a>&QUOT;</p>""",
	 	recipientProviders: [[$class: 'devEmail']]
	)
}
