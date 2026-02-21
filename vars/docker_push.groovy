def call(String Project, String ImageTag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: "DockerHubCred",
                                      passwordVariable: "DockerHubPass",
                                      usernameVariable: "DockerHubUser")]) {
        sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPass}"
        sh "docker push ${env.DockerHubUser}/${Project}:${ImageTag}"
    }
}
