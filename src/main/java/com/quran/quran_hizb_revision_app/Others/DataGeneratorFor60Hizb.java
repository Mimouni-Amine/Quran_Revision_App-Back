package com.quran.quran_hizb_revision_app.Others;

public class DataGeneratorFor60Hizb {
    public static void main (String [] args){


        for (int i=1; i<=60;i++){
            String Line1= "insert into revision (quarter_number,mastery,time_updated,urgency,ref_username) values (" +
                    i+".0, 'Empty', null, false,'Amine');";
            String Line2= "insert into revision (quarter_number,mastery,time_updated,urgency,ref_username) values (" +
                    i+".1, 'Empty', null, false,'Amine');";
            String Line3= "insert into revision (quarter_number,mastery,time_updated,urgency,ref_username) values (" +
                    i+".2, 'Empty', null, false,'Amine');";
            String Line4= "insert into revision (quarter_number,mastery,time_updated,urgency,ref_username) values (" +
                    i+".3, 'Empty', null, false,'Amine');";

            System.out.println(Line1);
            System.out.println(Line2);
            System.out.println(Line3);
            System.out.println(Line4);
        }

    }
}

//TODO: add an sql function that will (string User) and use this script to just set the value of the variable ${}
// nad apply it with each user added and to delete a User, use the java Delete post (Get all the list by name, then delete and save User)


