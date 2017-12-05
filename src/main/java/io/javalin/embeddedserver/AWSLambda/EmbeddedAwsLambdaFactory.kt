package io.javalin.embeddedserver.AWSLambda

import io.javalin.core.JavalinServlet
import io.javalin.embeddedserver.EmbeddedServer
import io.javalin.embeddedserver.EmbeddedServerFactory
import io.javalin.embeddedserver.StaticFileConfig

class EmbeddedAwsLambdaFactory : EmbeddedServerFactory {
    // Need to add static resource config handling
    override fun create(javalinServlet: JavalinServlet, staticFileConfig: StaticFileConfig?): EmbeddedServer {
        return EmbeddedAwsLambdaServer(javalinServlet)
    }

}