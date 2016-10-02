 (ns user
   (:require [figwheel-sidecar.repl-api]
             [clojurescript-ethereum-example.core]
             [ring.middleware.reload :refer [wrap-reload]]))

(set! *warn-on-reflection* true)
(set! *unchecked-math* :warn-on-boxed)

(def http-handler
  (wrap-reload #'clojurescript-ethereum-example.core/http-handler))