/**
 * Wipes the workspace and checks out a git repo.
 *
 * Example: 
 *
 *   checkoutRepo url: "git@git:somewhere/somerepo",
 *      branch: "master",
 *      credentials: "some-creds-id"
 *
 **/
def call(Map params) {

  checkout scm: [
    $class: 'GitSCM',
    userRemoteConfigs: [
      [
        url: params.url,
        credentialsId: params.credentials
      ]
    ],
    branches: [
      [
        name: params.branch
      ]
    ],
    extensions: [
      [
        $class: 'LocalBranch', 
        localBranch: 'master'
      ]
    ]
  ]
}
