#! /usr/bin/groovy
package com.spark

import com.spark.library

def pre(params, PROJECT, SPARK_BRANCH, SPARK_REPO) {
    def l = new library()
    l.test = "Hello world"
    l.print()
    node {
        stage("Pre") {
            echo "BUILD: ${BUILD}"
            echo "GO: ${GO}"
            echo "GOPATH: ${GOPATH}"
            echo "SPARK_PATH: ${SPARK_PATH}"
            echo "PROJECT: ${PROJECT}"
            echo "GoVersion: ${params.GoVersion}"
            echo "Branch: ${params.Branch}"

            sh "mkdir -p $SPARK_PATH"
            dir("${SPARK_PATH}") {
                git branch: "${SPARK_BRANCH}",
                        credentialsId: 'phtanus',
                        url: "${SPARK_REPO}"
            }
        }
    }
}
