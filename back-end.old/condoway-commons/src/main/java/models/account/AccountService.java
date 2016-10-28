package models.account;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by Carlos on 10/13/2016.
 */
@VertxGen
@ProxyGen
public interface AccountService {

    String SERVICE_NAME = "user-account-eb-service";
    String SERVICE_ADDRESS = "service.user.account";


    void save(Account account, Handler<AsyncResult<Void>> resultHandler);

    void retriever(String userID, Handler<AsyncResult<Account>> resultHandler);

    void remove(String userID, Handler<AsyncResult<Void>> resultHandler);

}
