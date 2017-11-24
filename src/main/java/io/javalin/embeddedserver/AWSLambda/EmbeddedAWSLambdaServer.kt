package io.javalin.embeddedserver.AWSLambda

import com.amazonaws.services.lambda.runtime.Context
import io.javalin.core.JavalinServlet
import io.javalin.embeddedserver.EmbeddedServer
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent

class EmbeddedAWSLambdaServer(private val javalinServlet: JavalinServlet) : EmbeddedServer {

    fun handleRequest(req : APIGatewayProxyRequestEvent, context: Context) : APIGatewayProxyResponseEvent {
        val res = APIGatewayProxyResponseEvent()
        javalinServlet.service(req, res)
        return res
    }

    override fun start(port: Int): Int {
        return 0
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun activeThreadCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attribute(key: String): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}