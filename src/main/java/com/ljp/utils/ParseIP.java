package com.ljp.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbMakerConfigException;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

public class ParseIP {

    private static DbConfig config = null;
    private static DbSearcher searcher = null;
    private static Logger logger = Logger.getLogger(ParseIP.class.getName());

    static {
        String dbfile = "src\\main\\resources/ip2region.db";
        try {
            config = new DbConfig();
            searcher = new DbSearcher(config, dbfile);
            System.out.println("success");
        }catch (DbMakerConfigException e){
            logger.warning("ip2region config init exception:" + e.getMessage());
        }catch (FileNotFoundException e){
            logger.warning("ip2region file not found" + e.getMessage());
        }
    }

    public static DataBlock parseIp(String ip){
        boolean isIpAddress = Util.isIpAddress(ip);
        if(isIpAddress){
            try {
                DataBlock block = searcher.btreeSearch(ip);
                return block;
            }catch (IOException e){
                logger.warning("ip2region parse error" + e.getMessage());
            }
        }
        return null;
    }

    public static void main(String args[]) throws Exception{
        // 格式：国家|大区|省份|城市|运营商
        System.out.println(ParseIP.parseIp("220.248.14.158").getRegion());
        System.out.println(ParseIP.parseIp("120.239.36.183").getRegion());
    }
}