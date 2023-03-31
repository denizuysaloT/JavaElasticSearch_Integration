package com.bigdatacompany.elastic;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws UnknownHostException {

        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        Map<String, Object> json = new HashMap<>();

        json.put("name","Asus Vivobook X542UR");
        json.put("detail","Intel Core i5,8GB RAM,1TB Harddisk");
        json.put("provider","Asus Türkiye");

        IndexResponse indexResponse = client.prepareIndex("product", "_doc", "1")
                .setSource(json, XContentType.JSON)
                .get();


    }

    }

