package com.condoway.account;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by Carlos on 10/16/2016.
 */
@ProxyGen
public interface AccountService {

    String SERVICE_NAME = "account-eb-service";

    String SERVICE_ADDRESS = "service.user.account";

    void add(Account account, Handler<AsyncResult<Void>> resultHandler);

    void retrieve(String id, Handler<AsyncResult<Account>> resultHandler);

    void retrieveByEmail(String email, Handler<AsyncResult<Account>> resultHandler);

    void update(Account account, Handler<AsyncResult<Account>> resultHandler);

    void delete(String id, Handler<AsyncResult<Void>> resultHandler);
}
