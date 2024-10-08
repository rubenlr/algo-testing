# Define variables for Maven commands
MVN=mvn
BENCHMARK_CLASS=com.rubenlr.DepthFirstSearchBenchmark
JMH_ARGS=-Dexec.mainClass="org.openjdk.jmh.Main" -Dexec.args=$(BENCHMARK_CLASS)

.PHONY: all clean build run

# Default target: run the benchmarks
all: build run

# Clean target: clean the Maven project
clean:
	$(MVN) clean

# Build target: compile and package the project
build:
	$(MVN) clean install

# Run target: execute the JMH benchmarks
run:
	$(MVN) exec:java $(JMH_ARGS)
