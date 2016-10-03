# Clojure Ethereum Example

This is source code for tutorial [How to create decentralised apps with Clojurescript re-frame and Ethereum](https://medium.com/@matus.lestan/how-to-create-decentralised-apps-with-clojurescript-re-frame-and-ethereum-81de24d72ff5#.nvfyq27lb)

Deployed at https://clojurescript-ethereum-example.herokuapp.com/

## Start App
Start Solidity auto compiling
```
lein auto compile-solidity
```
Start less compiling
```
lein less4j auto
```
Start App
```
lein repl
```
```clojure
(clojurescript-ethereum-example.core/-main)
(figwheel-sidecar.repl-api/start-figwheel! (figwheel-sidecar.config/fetch-config))
(figwheel-sidecar.repl-api/cljs-repl)
```
Open at http://localhost:6655/

