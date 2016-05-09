# Simple Kafka Consumer written in Apache Spark (Java)
Even I'm learning the concept of Apache Spark. Feel free to update the repo.

The consumer will just dump whatever its on the bus on to the terminal.

	brew install spark
	brew install kafka

	brew services start zookeeper
	brew services start kafka

go to your ```apache-spark/1.6.1/libexec folder```
	./sbin/start-master.sh
the  ```.out``` file should say ```Starting Spark master at spark://${your_computer_name}:7077```
	./sbin/start-slave.sh spark://${name_of_your_master}
the last line of the ```.out``` file should be ```Successfully registered with master spark://${your_computer_name}:7077```

go to ```Simple_Spark-Kafka_Consumer/spark1/twitter```
	mvn clean
	mvn install

go to target folder
	spark-submit --class kafka_consumer.twitter.App --master spark://localhost:7077 twitter-0.0.1-SNAPSHOT-jar-with-dependencies.jar

> To execute, the jar needs to be submitted to spark.
