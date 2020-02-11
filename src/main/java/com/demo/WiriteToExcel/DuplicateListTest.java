/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.WiriteToExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author LingaRao
 */
public class DuplicateListTest {

    @SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
        List<Map<String, String>> listMap = new ArrayList() {
            {
                add(new HashMap() {
                    {
                        put("Mobile_No", "919652577984");
                    }

                    {
                        put("Name", "Linga");
                    }

                    {
                        put("City", "Hyderabad");
                    }
                });
            }

            {
                add(new HashMap() {
                    {
                        put("Mobile_No", "919652577985");
                    }

                    {
                        put("Name", "Linga1");
                    }

                    {
                        put("City", "Hyderabad1");
                    }
                });
            }

            {
                add(new HashMap() {
                    {
                        put("Mobile_No", "919652577986");
                    }

                    {
                        put("Name", "Linga2");
                    }

                    {
                        put("City", "Hyderabad2");
                    }
                });
            }

            {
                add(new HashMap() {
                    {
                        put("Mobile_No", "919652577987");
                    }

                    {
                        put("Name", "Linga3");
                    }

                    {
                        put("City", "Hyderabad3");
                    }
                });
            }

            {
                add(new HashMap() {
                    {
                        put("Mobile_No", "919652577987");
                    }

                    {
                        put("Name", "Linga4");
                    }

                    {
                        put("City", "Hyderabad4");
                    }
                });
            }
            
            {
                add(new HashMap() {
                    {
                        put("Mobile_No", "919652577987");
                    }

                    {
                        put("Name", "Linga5");
                    }

                    {
                        put("City", "Hyderabad6");
                    }
                });
                add(new HashMap() {
                    {
                        put("Mobile_No", "919652577987");
                    }

                    {
                        put("Name", "Linga5");
                    }

                    {
                        put("City", "Hyderabad6");
                    }
                });
                add(new HashMap() {
                    {
                        put("Mobile_No", "919652577984");
                    }

                    {
                        put("Name", "Linga");
                    }

                    {
                        put("City", "Hyderabad");
                    }
                });
            }
        };
        
        HashMap<String, Integer> dupCount = new HashMap<String,Integer>();
        HashMap<String, Integer> duplicateMobAndCount = new HashMap<String,Integer>();
        listMap.stream().filter(e->null !=e && e.size()>0).forEach(map1->{
        	map1.entrySet().stream().forEach(mob->{
        		if(mob.getKey().equals("Mobile_No")){
        			if(dupCount.containsKey(mob.getValue())) {
        				dupCount.put(mob.getValue(),dupCount.get(mob.getValue())+1);
        				duplicateMobAndCount.put(mob.getValue(),dupCount.get(mob.getValue()));
        			}else {
        				dupCount.put(mob.getValue(),1);
        			}
        		}
        		
        	});
        });
        
        dupCount.forEach((k,v)->{
        	if(v !=1) {
        		System.out.println(k+"="+v);
        	}
        });

        HashMap<String, Map<String, String>> hashMap = new HashMap<String,Map<String, String>>();
        HashMap<String, Map<String, String>> hashMap1 = new HashMap<String,Map<String, String>>();
        
        	 listMap.stream().filter(length->null !=length && length.size()>0).forEach(map1->{
        		 
        		 map1.entrySet().stream().forEach(data->{
            		 if(data.getKey().equals("Mobile_No")){
            			 if(hashMap.containsKey(data.getValue())) {
             				hashMap.put(data.getValue(), map1);
             				hashMap1.put(data.getValue(), map1);
             			}else {
             				hashMap.put(data.getValue(), map1);    
             			}
            		 }
            	 });
        	 });
        	 
        	 hashMap1.forEach((k,v)->System.out.println(k+"="+v));
        	 
        	 try {
				SimpleExcelWriterExample.writetoExcel(hashMap1,duplicateMobAndCount);
			} catch (IOException e) {
				e.printStackTrace();
			}
        	 
        }
    }
       

    
