package id.fivebyte;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

public class TopologyMain {
    public static void main(String[] args) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("simple-spout", new DataSpout());
        builder.setBolt("simple-bolt", new MysqlBolt()).shuffleGrouping("simple-spout");

        Config conf = new Config();
        conf.setDebug(true);

//        StormSubmitter.submitTopology("simple", conf, builder.createTopology());

        LocalCluster cluster = new LocalCluster();
        try {
            cluster.submitTopology("topology-main", conf, builder.createTopology());
            Utils.sleep(30000);
        } finally {
            cluster.shutdown();
        }

    }
}
