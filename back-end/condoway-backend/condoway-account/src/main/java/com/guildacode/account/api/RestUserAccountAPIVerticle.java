package com.guildacode.account.api;

import com.condoway.account.Account;
import com.condoway.account.AccountService;
import com.guildacode.common.RestAPIVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by Carlos on 10/16/2016.
 */
public class RestUserAccountAPIVerticle extends RestAPIVerticle {

    private static final String SERVICE_NAME = "user-account-rest-api";

    private final AccountService accountService;

    private static final String API_ADD = "/users";
    private static final String API_RETRIEVE = "/users/:id";
    private static final String API_RETRIEVEBYEMAIL = "/users/:id/email/:email";
    private static final String API_UPDATE = "/users/:id";
    private static final String API_DELETE = "/users/:id";

    public RestUserAccountAPIVerticle(AccountService service){
        this.accountService = service;
    }

    @Override
    public void start(Future<Void> future) throws Exception {
        super.start(future);

        final Router router = Router.router(vertx);
        // body handler
        router.route().handler(BodyHandler.create());

        // api route handler
        router.post(API_ADD).handler(this::apiAddUser);
        router.get(API_RETRIEVE).handler(this::apiRetrieveUser);
        router.get(API_RETRIEVEBYEMAIL).handler(this::apiRetrieveUserByEmail);
        router.put(API_UPDATE).handler(this::apiUpdateUser);
        router.delete(API_DELETE).handler(this::apiDeleteUser);

        enableHeartbeatCheck(router, config());

        String host = config().getString("user.account.http.address", "0.0.0.0");
        int port = config().getInteger("user.account.http.port", 8081);

        createHttpServer(router, host, port)
                .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME, host, port))
                .setHandler(future.completer());
    }

    private void apiAddUser(RoutingContext context) {
        Account account = new Account(context.getBodyAsJson());
        account.setId(java.util.UUID.randomUUID().toString());

        accountService.add(account, resultVoidHandler(context, account.toJson()));
    }

    private void apiRetrieveUser(RoutingContext context){
        String id = context.request().getParam("id");
        accountService.retrieve(id, resultHandlerNonEmpty(context));
    }

    private void apiRetrieveUserByEmail(RoutingContext context){
        String email = context.request().getParam("email");
        accountService.retrieveByEmail(email, resultHandlerNonEmpty(context));
    }

    private void apiUpdateUser(RoutingContext context){
        notImplemented(context);
    }

    private void apiDeleteUser(RoutingContext context) {
        String id = context.request().getParam("id");
        accountService.delete(id, deleteResultHandler(context));
    }
}
