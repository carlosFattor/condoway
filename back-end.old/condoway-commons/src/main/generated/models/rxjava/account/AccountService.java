/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package models.rxjava.account;

import java.util.Map;
import rx.Observable;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import models.account.Account;

/**
 * Created by Carlos on 10/13/2016.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link models.account.AccountService original} non RX-ified interface using Vert.x codegen.
 */

public class AccountService {

  final models.account.AccountService delegate;

  public AccountService(models.account.AccountService delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public void save(Account account, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.save(account, resultHandler);
  }

  public Observable<Void> saveObservable(Account account) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    save(account, resultHandler.toHandler());
    return resultHandler;
  }

  public void retriever(String userID, Handler<AsyncResult<Account>> resultHandler) { 
    delegate.retriever(userID, resultHandler);
  }

  public Observable<Account> retrieverObservable(String userID) { 
    io.vertx.rx.java.ObservableFuture<Account> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    retriever(userID, resultHandler.toHandler());
    return resultHandler;
  }

  public void remove(String userID, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.remove(userID, resultHandler);
  }

  public Observable<Void> removeObservable(String userID) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    remove(userID, resultHandler.toHandler());
    return resultHandler;
  }


  public static AccountService newInstance(models.account.AccountService arg) {
    return arg != null ? new AccountService(arg) : null;
  }
}
