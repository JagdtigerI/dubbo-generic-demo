package com.dulio.demo.dubboServiceA.extend;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;

import java.util.List;

public class DemoLoadBalance implements LoadBalance {
    private final static RandomLoadBalance loadBalance = new RandomLoadBalance();

    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        Invoker invoker = loadBalance.select(invokers, url, invocation);
        return invoker;
    }
}
