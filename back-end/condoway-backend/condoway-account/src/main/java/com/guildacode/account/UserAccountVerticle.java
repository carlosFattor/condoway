package com.guildacode.account;

import com.condoway.account.AccountService;
import com.guildacode.account.api.RestUserAccountAPIVerticle;
import com.guildacode.account.impl.UserAccountServiceImpl;
import com.guildacode.common.BaseMicroserviceVerticle;
import io.vertx.core.Future;
import io.vertx.core.DeploymentOptions;

import static com.condoway.account.AccountService.SERVICE_ADDRESS;
import static com.condoway.account.AccountService.SERVICE_NAME;

/**
 * Created by Carlos on 10/16/2016.
 */
public class UserAccountVerticle extends BaseMicroserviceVerticle {

    private AccountService accountService;

    @Override
    public void start(Future<Void> future) throws Exception {
        super.start();

        accountService = new UserAccountServiceImpl(vertx, config());
        publishEventBusService(SERVICE_NAME, SERVICE_ADDRESS, AccountService.class)
                .compose(servicePublished -> deployRestVerticle(accountService))
                .setHandler(future.completer());
    }

    private Future<Void> deployRestVerticle(AccountService service) {
        Future<String> future = Future.future();
        vertx.deployVerticle(new RestUserAccountAPIVerticle(service),
                new DeploymentOptions().setConfig(config()),
                future.completer());
        return future.map(r -> null);
    }
}
