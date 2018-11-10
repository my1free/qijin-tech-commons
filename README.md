commons

在commons生成子module步骤:

1. 进入commons目录

> cd commons

2. 通过aviagames-quickstart生成module

执行：

```
mvn archetype:generate -DarchetypeGroupId=com.aviagames.archetype -DarchetypeArtifactId=aviagames-quickstart -DarchetypeVersion=1.0 -DgroupId=com.aviagames.commons  -DartifactId=commons-demo  -Dversion=1.0.0-SNAPSHOT  -Dpackage=com.aviagames.commons.demo -DparentVersion=1.0.0-SNAPSHOT -DinteractiveMode=false
```

注意：将上面的"demo"修改成你所需要的工程的名字

2. 执行完上面的命令后，会自动生成以下内容:

```
commons-demo/
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── aviagames
    │               └── commons
    │                   └── demo
    │                       └── App.java
    └── test
        └── java
            └── com
                └── aviagames
                    └── commons
                        └── demo
                            └── AppTest.java
```

同时会在commons目录下的pom.xml文件中自动添加module

```xml
<module>commons-demo</module>
```

注：自动添加的module格式不怎么好，有强迫症的话，可以手动调节

3. 修改commons-demo/pom.xml中的artifactId为demo

注：按上面的步骤生成的module，指定的artifactId为commons-demo。我们建议把commons去掉，因此需要修改。
如果不想去掉也没关系，用commons-demo这种artifactId也无可厚非。我是个佛性的人

