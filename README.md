# Social_Network
Because I don't have the windows pro edition I can't run docker on it. This made me install neo4j on the host machine. I couldn't get neo4j to work with the large csv files, so I'll use the small version which Helge has uploadet.

## requirements
Java<br>
Maven<br>
Neo4J (windows host, neo4j.org/download)<br>
MySQL workbench

## import csv file
You first import the .tar.gz file from: https://github.com/datsoftlyngby/soft2018spring-databases-teaching-material/raw/master/data/archive_graph.tar.gz.

then you unpack it with the command "tar -xzf rebol.tar.gz"

## Neo4j cypher import
I used the commands from helges slides:

```
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/datsoftlyngby/soft2018spring-databases-teaching-material/master/data/social_network_nodes_small.csv" AS row
MERGE (:Person {id: toInt(row.node_id), name: row.name, job: row.job, 
                          birthday: row.birthday});
```

```
USING PERIODIC COMMIT 5000
LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/datsoftlyngby/soft2018spring-databases-teaching-material/master/data/social_network_edges_small.csv" AS row
MATCH (f:Person {id: toInt(row.source_node_id)}), 
                      (t:Person {id: toInt(row.target_node_id)})
CREATE (f)-[:ENDORSES]->(t);
```

## MySQL import
made my own db and tables.
Inside the MySQL workbench you have the option to import data into the tables, which I did.

I have a problem though with MySQL, it is unable to load authentication plugin "caching_sha2_password".
