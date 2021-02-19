# Springboot Tekton Demo

An demo for tekton on OCP 4.x.

# Setup

The demo is installed with [Helm](https://heml.io/).

The chart is located in the ```restservice-chart``` folder.

1. Create a new OpenShift project:

```oc new-project springboot-pipeline-demo```

2. Install Tekton Operator (Optional if not installed)

```oc apply -f pipelines-operator.yaml```

3. Test the chart with a dry run (just to be sure that everyrhing is formally fine):

```helm install --generate-name --dry-run restservice-chart```

4. Go to the project source root and install the chart: 

```helm install --generate-name restservice-chart```

5. At the end of installation in  the *"Post install Front End setup for demo"* the chart will **output a command** to update the frontend deployment environment variables with urls of the two ReST services: **copy the command and run it** (you need to be logged in your openshift). The command is something like:

```
oc patch  deployment/restservice-chart-1605264575-fe -p "{\"spec\":{\"template\":{\"spec\":{\"containers\":[{\"env\":[{\"name\":\"BOOKSAPIURL\",\"value\":\"http://$(oc get route springboot-books-api -o jsonpath='{.status.ingress[0].host}' --namespace springboot-demo)\"},{\"name\":\"BOOKSTOCKAPIURL\",\"value\":\"http://$(oc get route springboot-stock-api  -o jsonpath='{.status.ingress[0].host}' --namespace springboot-demo)\"}],\"name\":\"restservice-chart-fe\"}]}}}}" --namespace springboot-demo
```

6. Start the Tekton pipelines

   ```oc apply -f pipelineruns/```


Alternatively Login into web console and run the three pipelines:

* ```front-end-pipeline``` (run the pipeline with the pvc ```fe-pipeline-pvc```)
* ```books-api-pipeline``` (run the pipeline with the pvc ```books-api-pipeline-pvc```)    
* ```stock-api-pipeline``` (run the pipeline with the pvc ```stock-api-pipeline-pvc```)

At the end you will have the three applications running.
