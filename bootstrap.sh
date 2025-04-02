echo "Execute Kubernetes manifest"
# shellcheck disable=SC2164
cd manifest
kubectl apply -f .
# shellcheck disable=SC2103
cd ..

for i in {1..2}; do
    cd go-$i || exit 1
    pwd
    kubectl apply -f manifest.yml
    cd .. || exit 1
done

for i in {1..4} ; do
    cd java-$i || exit 1
    pwd
    kubectl apply -f manifest.yml
    cd .. || exit 1
done

echo "Kubernetes manifests applied successfully."