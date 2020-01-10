/**
 * Use git leak to scan repository for stored secrets.
 *
 * Example: 
 *
 * 	??????????????????????????
 *
 **/
def call(Map params) {

	checkoutRepo(url: "https://github.com/awslabs/git-secrets.git", branch: "*/master", credentials: "github")
	sh "ls -alh"
	sh "make install"
	sh "git secrets --scan"
}