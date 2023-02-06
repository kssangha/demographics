package com.demographics.demographicsapi.services;

import org.springframework.stereotype.Service;
import com.demographics.demographicsapi.models.*;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;

@Service
public class DemographicsService {
    public Data data;

    public Data getDemographicsData(long lat, long lng){
        //ArrayList<Data> dataSet= populateDemographicsData();
        //return dataSet.get(findAreaId(lat, lng));
        return this.data;
    }

    public String addDemographicsData(Data data){
        this.data = data;
        return "Saved";
    }

    /**
     *  [0,1]
     *  [2,3]
     *
     *  I would have liked to have a DB with a set of data objects in which each object
     *  had an ID. The ID would be corresponding to the area on a grid based on the lat
     *  and lng values. Similar to above but with ranges: 90 > lat > -90 & 180 > lng > -180
     *
     *  By using the Spring CrudRepository, the implementation would be simple. Without the
     *  data however, I do not beleive it would be useful at this time.
     */

    private int findAreaId(long lat, long lng){
        int[] quadrants = {0,1,2,3};

        if (lat > 0 && lng > 0) {
            return 1;
        }
        else if (lat > 0 && lng < 0) {
            return 0;
        }
        else if (lat < 0 && lng < 0) {
            return 2;
        }
        else {
            return 3;
        }

    }


    private ArrayList<Data> populateDemographicsData(){
        Variable variable1 = new Variable();
        variable1.setVariable("avg_household_income");
        variable1.setValue(88555.1858);
        variable1.setLabel("Average household income");

        Variable variable2 = new Variable();
        variable2.setVariable("avg_individual_income");
        variable2.setValue(88555.1858);
        variable2.setLabel("Average individual income");

        ArrayList<Variable> attributeVariables1 = new ArrayList<>();
        attributeVariables1.add(variable1);
        attributeVariables1.add(variable2);

        Variable variable3 = new Variable();
        variable3.setVariable("transit");
        variable3.setValue(0.3483);
        variable3.setLabel("Transit");

        Variable variable4 = new Variable();
        variable4.setVariable("foot");
        variable4.setValue(0.271);
        variable4.setLabel("Foot");

        Variable variable5 = new Variable();
        variable5.setVariable("bicycle");
        variable5.setValue(0.115);
        variable5.setLabel("Bicycle");

        Variable variable6 = new Variable();
        variable6.setVariable("drive");
        variable6.setValue(0.2339);
        variable6.setLabel("Drive");

        ArrayList<Variable> attributeVariables2 = new ArrayList<>();
        attributeVariables2.add(variable3);
        attributeVariables2.add(variable4);
        attributeVariables2.add(variable5);
        attributeVariables2.add(variable6);

        Attribute attribute1 = new Attribute();
        attribute1.setLabel("income");
        attribute1.setType("standalone");
        attribute1.setVariables(attributeVariables1);

        Attribute attribute2 = new Attribute();
        attribute2.setLabel("commute_mode");
        attribute2.setType("percent");
        attribute2.setVariables(attributeVariables2);

        ArrayList<Attribute> attributes1 = new ArrayList<>();
        attributes1.add(attribute1);
        attributes1.add(attribute2);

        ArrayList<Data> dataSet = new ArrayList<>();

        for (int i = 0; i<4; i++){
            Data demographicsData = new Data();
            demographicsData.setType("Demographics" + i);
            demographicsData.setAttributes(attributes1);

            dataSet.add(demographicsData);
        }
        return dataSet;
    }

}
