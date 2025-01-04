# Localstack Setup

## Windows

### Configuring AWS CLI - To work with Localstack

---
#### ROOT User creation

##### Login to Localstack docker container

```
docker ps
```

```
docker exec -it localstack-main sh
```

<img src="../../Screenshots/Localstack/1DockerPS.png">

##### Create `ROOT` User

```
awslocal iam create-user --user-name root
```

<img src="../../Screenshots/Localstack/2CreateRootUser.png">

##### Create *SECRET KEYS* for `ROOT` User

```
awslocal iam create-access-key --user root
```

<img src="../../Screenshots/Localstack/3CreateSecretKeysForRootUser.png">

##### ROOT User Caller Identity

```
awslocal sts get-caller-identity
```

<img src="../../Screenshots/Localstack/4RootCallerIdentity.png">


#### Configuring AWS CLI in Windows

```
aws configure
```

```
aws configure list
```

<img src="../../Screenshots/Localstack/5ConfigureAndList.png">

NOTE: Copy AccessKeyId and SecretAccessKey from above steps

#### Using AWS CLI with Localstack

```
aws --endpoint-url=http://localhost:4566 sts get-caller-identity
```

<img src="../../Screenshots/Localstack/6RootCallerIdentityFromHost.png">
