@echo off
echo Execute Kubernetes manifest

cd manifest
kubectl apply -f .
cd ..

for %%i in (1 2) do (
    cd go-%%i
    cd
    kubectl apply -f manifest.yml
    cd ..
)

for %%i in (1 2 3 4) do (
    cd java-%%i
    cd
    kubectl apply -f manifest.yml
    cd ..
)

echo Kubernetes manifests applied successfully.
