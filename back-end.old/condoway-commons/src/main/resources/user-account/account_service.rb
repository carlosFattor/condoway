require 'vertx/util/utils.rb'
# Generated from models.account.AccountService
module UserAccount
  #  Created by Carlos on 10/13/2016.
  class AccountService
    # @private
    # @param j_del [::UserAccount::AccountService] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::UserAccount::AccountService] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [Hash] account 
    # @yield 
    # @return [void]
    def save(account=nil)
      if account.class == Hash && block_given?
        return @j_del.java_method(:save, [Java::ModelsAccount::Account.java_class,Java::IoVertxCore::Handler.java_class]).call(Java::ModelsAccount::Account.new(::Vertx::Util::Utils.to_json_object(account)),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling save(account)"
    end
    # @param [String] userID 
    # @yield 
    # @return [void]
    def retriever(userID=nil)
      if userID.class == String && block_given?
        return @j_del.java_method(:retriever, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(userID,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling retriever(userID)"
    end
    # @param [String] userID 
    # @yield 
    # @return [void]
    def remove(userID=nil)
      if userID.class == String && block_given?
        return @j_del.java_method(:remove, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(userID,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling remove(userID)"
    end
  end
end
