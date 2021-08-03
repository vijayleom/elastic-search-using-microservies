# elastic-search-using-microservies

elastic-search-using-microservies is a Spring Boot based Microservice project. There will be two distinctive services getting executed.
And logger files particular to the services will be genrated based on the consumption of the rest services. Log file location and the file name are configured 
in the applciation.yml. To have understanding on the profiles - my-first-app is configured with the profile and my-sec-app works with default profile.

## Run Java Application

```bash
mvn springboot-run
```
Note: The embedded tomcat will serve the rest service under the port mentioned under application.yml

## Usage of ELK

**Download the below agents from elastic.co**

[Elastic](https://www.elastic.co/downloads/elasticsearch) - Elasticsearch is a RESTful distributed search engine
[LogStash](https://www.elastic.co/downloads/logstash) - LogStash is NoSQL based Database which will be a pipe to get the log details
[Kibana](https://www.elastic.co/downloads/kibana) - Kibana is the front end component that helps in discovering the consolidated log information.

## Procedure to start the agents:

1. Start the Elastic search first. Go to bin directory of the elasticsearch agent folder and execute the below:
```
./elasticsearch
```
  This runs on 9200 port by default.
2. Before starting logstash, copy the logstash.config provided inside the **ELK Files** in the above repository to the bin directory of the logstash agent. 
Now execute the below:
```
./logstash -f logstash.config
```
Once logstash is started the log details in the log files are loaded as NoSQL entries and push in the pipe to the 9200 port as configured in the config file.
3. Before starting kibana, copy the kibana.yml provided inside the **ELK Files** in the above repository to the bin directory of the kibana agent. 
Now execute the below:
```
./kibana
```
  This runs on 5602 port by default.


## Configuration in the Kibana

1. Once you access kibana in 5602 port - Goto Stack Management -> Kibana Index Pattern
2. Provide the index as leo_logger_test. You will the index coming in below:
![Index](https://www.dropbox.com/s/84bsylyltuhi8qh/Screenshot%202021-08-03%20at%204.58.54%20PM.png)
3. In Step 2 of 2: Configure settings, choose "I don't want to use time filter" and click "Create Index Pattern"
4. You will see the field that are pre rendered which now can be used as filters in the consolidated logger search.
5. Goto "Discover" under analytics as in below:
![Discover](https://www.dropbox.com/s/dlmjuacu4l4gu2y/Screenshot%202021-08-03%20at%205.03.04%20PM.png)
6. You can choose the respective field from the side panel to see specific information on the logger related.
![Filter](https://www.dropbox.com/s/nqub8e8o1rfe8hf/Screenshot%202021-08-03%20at%205.05.24%20PM.png)
7. You can also configure the analytics dashboard based on the fields that got created from the index. This will help in Graphical representation of the data.

## Queries:

- Need to get the full benefit of the visulization of the log information in the Dashboard with apt filters.
- Adding custom filter based on patterns to track the log.
- Filtering keywords in "KQL" to support the special characters based filtering in the search under the message field.
![Filtering Limitations](https://www.dropbox.com/s/6h9s38bwk9l3a5l/Screenshot%202021-08-03%20at%205.11.54%20PM.png)

-- Please add your suggestion or correctness in case any uncovered.
