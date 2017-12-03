package io.javalin.embeddedserver.AWSLambda

import io.javalin.core.JavalinServlet
import io.javalin.embeddedserver.EmbeddedServer
import io.javalin.embeddedserver.EmbeddedServerFactory
import io.javalin.embeddedserver.StaticFileConfig
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.util.thread.QueuedThreadPool


class EmbeddedAWSLambdaFactory : EmbeddedServerFactory {
    // Need to add static resource config handling
    override fun create(javalinServlet: JavalinServlet, staticFileConfig: StaticFileConfig?): EmbeddedServer {
        return EmbeddedAWSLambdaServer(javalinServlet)
    }

}