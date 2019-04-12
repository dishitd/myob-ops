# Ops Sample Application
[![Build Status](https://travis-ci.org/dishitd/myob-ops.svg?branch=develop)](https://travis-ci.org/dishitd/myob-ops)

## Project Description
This project was created to demonstrate one of the ways by which a simple Java application built using Maven is containerized using Docker and deployed to AWS instances using Travis-CI

## Solution Design
![Solution Design](https://github.com/dishitd/myob-ops/raw/develop/figures/Solution%20Design.png)

## Deployment Steps Pipeline
![Deployment Pipeline](https://github.com/dishitd/myob-ops/raw/develop/figures/Deployment%20Pipeline.png)

## APIs Deployed
* Application Primary URL - http://\<elb url\>/api/getresult
* Application metadata URL - http://\<elb url\>/api/metadata
* Application metadata URL - http://\<elb url\>/api/health

## Pre-requisites to Deployment
1. Have account on  [Dockerhub](https://hub.docker.com/) 
2. AWS Account
3. Account on [Travis-CI](https://travis-ci.org/) 
4. Authorize Travis-CI to access Github repository
5. Create a clone of [Github](https://github.com/dishitd/myob-ops) repository
6. Enable project myob-ops to be integrated with Travis-CI through Settings at account level


## Deployment Steps

1. Create an IAM user 
    1. Having Programmatic Access
    2. Capture the Access Key and Secret Access Key of the user
    3. Attach all existing policies for AWS Elasticbeanstalk by searching for elasticbeanstalk in policy list

2. Create an application using ElasticBeanStalk
    1. Create an application - Provide any name. Currently provided is "ops-stack"
    2. Create an environment with below settings. Environment name provided in travis.yml file currently is "OpsStack-env-1"
        1. Select Web server environment
        2. Select Docker MultiContainer as platform
        3. Select Configure More Options and associate default VPC and subnet in which the application needs to be deployed by selecting the Network Options
        4. Enter Domain name which will become part of the application url if needed
        5. Click on Create Environment

3. Update environment variables for myob-ops repository in Travis-CI. Mark all as hidden
    1. AWS_ACCESS_KEY : Update the value of AWS Access Key which was generated as part of creation of IAM user
    2. AWS_SECRET_KEY : Update the value of AWS secret key 
    3. DOCKER_ID : Provide docker id based on account on dockerhub
    4. DOCKER_PASSWORD : Provide docker password 

4. Update image name to own repository in Dockerrun.aws.json file
    
5. Update travis.yml file with below changes
    1. Update region name if beanstalk is deployed in region other than ap-southeast-2
    2. Update app and env value with elasticbeanstalk application and environment
    3. Update the bucket-name parameter with the S3 bucket name created for beanstalk
    4. Bucket path is same as application name
       
6. Commit and push the changes to master branch which triggers auto-deployment to AWS 
7ß. The application will be available at the elasticbeanstalk environment url


## Limitations
* Currently, number of instance for both nginx and api containers can only be increased simultaneously. 

## Improvements
* Auto-scaling can be configured to increase the number of instance based on the load
* Using Kubernetes, configuration can be changed to increase the scalability of only API instances
* Using Application Loadbalancers, nginx layer can be avoided altogether



## Possible Issues
1. ### Application is not accessible from ELB url
    
    * VPC might not have been attached to ELB. 
        #### Solution: Delete environment and create new environment with VPC configured
    * Docker instances must have exited. Memory usage for docker instances might be more than EC2 instance memory config
        #### Solution: Either modify beanstalk ec2 instance type to medium instnace or reduce the memory config for docker isntances

