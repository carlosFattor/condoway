package com.guildacode.account.impl;

import com.condoway.account.Account;
import com.condoway.account.AccountService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;

/**
 * Created by Carlos on 10/16/2016.
 */
public class UserAccountServiceImpl implements AccountService {

    private static final String COLLECTION = "account";

    private final MongoClient client;

    public UserAccountServiceImpl(Vertx vertx, JsonObject config) {
        this.client = MongoClient.createNonShared(vertx, config);
    }

    @Override
    public void add(Account account, Handler<AsyncResult<Void>> resultHandler) {
        client.save(COLLECTION, account.toJson(), ar -> {
            if(ar.succeeded()){
                resultHandler.handle(Future.succeededFuture());
            } else {
                resultHandler.handle(Future.failedFuture(ar.cause()));
            }
        });
    }

    @Override
    public void retrieve(String id, Handler<AsyncResult<Account>> resultHandler) {
        JsonObject query = new JsonObject().put("_id", id);

        client.findOne(COLLECTION, query, null, ar -> {
            if(ar.succeeded()){
                if(ar.result() == null){
                    resultHandler.handle(Future.succeededFuture());
                } else {
                    Account account = new Account(ar.result());
                    resultHandler.handle(Future.succeededFuture(account));
                }
            } else {
                resultHandler.handle(Future.failedFuture(ar.cause()));
            }
        });
    }

    @Override
    public void retrieveByEmail(String email, Handler<AsyncResult<Account>> resultHandler) {
        JsonObject selectedEmail = new JsonObject().put("email", email);
        JsonObject query = new JsonObject().put("profile", new JsonObject().put("$elemMatch", selectedEmail));

        client.findOne(COLLECTION, query, null, ar -> {
            if(ar.succeeded()){
                if(ar.result() == null){
                    resultHandler.handle(Future.succeededFuture());
                } else {
                    Account account = new Account(ar.result());
                    resultHandler.handle(Future.succeededFuture(account));
                }
            } else {
                resultHandler.handle(Future.failedFuture(ar.cause()));
            }
        });
    }

    @Override
    public void update(Account account, Handler<AsyncResult<Account>> resultHandler) {
        JsonObject query = new JsonObject().put("_id", account.getId());
        client.updateCollection(COLLECTION, query, null, ar -> {
            if(ar.succeeded()){
                Account accountRes = new Account(ar.result().toJson());
                resultHandler.handle(Future.succeededFuture(accountRes));
            } else {
                resultHandler.handle(Future.failedFuture(ar.cause()));
            }
        });
    }

    @Override
    public void delete(String id, Handler<AsyncResult<Void>> resultHandler) {
        JsonObject query = new JsonObject().put("_id", id);
        client.removeDocument(COLLECTION, query, ar -> {
            if(ar.succeeded()){
                resultHandler.handle(Future.succeededFuture());
            } else {
                resultHandler.handle(Future.failedFuture(ar.cause()));
            }
        });
    }
}
