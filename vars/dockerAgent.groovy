/**
 * Uses docker and the correct docker images.
 *
 * Example: 
 *
 *   dockerAgent (image: "maven:3.5.0-jdk-8", reuseNode: "true")
 *      
 *
 **/
def call(Map params) { 
    agent {
        docker {
          /*
           * Reuse the workspace on the agent defined at top-level of Pipeline but run inside a container.
           * In this case we are running a container with maven so we don't have to install specific versions
           * of maven directly on the agent
           */
          reuseNode params.reuseNode
          image params.image
		}
	}
}