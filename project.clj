(defproject clojurescript-ethereum-example "0.1.0-SNAPSHOT"
  :dependencies [[bk/ring-gzip "0.1.1"]
                 [cljs-ajax "0.5.8"]
                 [cljs-react-material-ui "0.2.22"]
                 [cljs-web3 "0.16.0-0"]
                 [cljsjs/bignumber "2.1.4-1"]
                 [cljsjs/react-flexbox-grid "0.10.2-1" :exclusions [cljsjs/react]]
                 [com.andrewmcveigh/cljs-time "0.4.0"]
                 [compojure "1.6.0-beta1"]
                 [day8.re-frame/http-fx "0.0.4"]
                 [environ "1.0.3"]
                 [http-kit "2.2.0"]
                 [madvas.re-frame/web3-fx "0.1.0"]
                 [medley "0.8.3"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [print-foo-cljs "2.0.3"]
                 [re-frame "0.8.0"]
                 [reagent "0.6.0" :exclusions [cljsjs/react]]
                 [ring.middleware.logger "0.5.0"]
                 [ring/ring-core "1.6.0-beta5"]
                 [ring/ring-defaults "0.3.0-beta1"]
                 [ring/ring-devel "1.6.0-beta5"]]

  :plugins [[lein-auto "0.1.2"]
            [lein-cljsbuild "1.1.4"]
            [lein-shell "0.5.0"]
            [deraen/lein-less4j "0.5.0"]]

  :min-lein-version "2.5.3"
  :main clojurescript-ethereum-example.core

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]
             :server-port 6777
             :ring-handler user/http-handler}

  :auto {"compile-solidity" {:file-pattern #"\.(sol)$"
                             :paths ["resources/public/contracts/src"]}}

  :aliases {"compile-solidity" ["shell" "./compile-solidity.sh"]}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :less {:source-paths ["resources/public/less"]
         :target-path "resources/public/css"
         :target-dir "resources/public/css"
         :source-map true
         :compression true}

  :uberjar-name "clojurescript-ethereum-example.jar"

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.8.2"]
                   [com.cemerick/piggieback "0.2.1"]
                   [figwheel-sidecar "0.5.8"]
                   [org.clojure/tools.nrepl "0.2.11"]]
    :plugins [[lein-figwheel "0.5.8"]]
    :source-paths ["env/dev"]
    :cljsbuild {:builds [{:id "dev"
                          :source-paths ["src/cljs"]
                          :figwheel {:on-jsload "clojurescript-ethereum-example.core/mount-root"}
                          :compiler {:main clojurescript-ethereum-example.core
                                     :output-to "resources/public/js/compiled/app.js"
                                     :output-dir "resources/public/js/compiled/out"
                                     :asset-path "/js/compiled/out"
                                     :source-map-timestamp true
                                     :optimizations :none
                                     :closure-defines {goog.DEBUG true}
                                     :preloads [print.foo.preloads.devtools]}}]}}

   :uberjar {:hooks [leiningen.cljsbuild]
             :omit-source true
             :aot :all
             :main emojillionaire.core
             :cljsbuild {:builds {:app {:id "uberjar"
                                        :source-paths ["src/cljs"]
                                        :compiler {:main clojurescript-ethereum-example.core
                                                   :output-to "resources/public/js/compiled/app.js"
                                                   :optimizations :advanced
                                                   :closure-defines {goog.DEBUG false}
                                                   :pretty-print true
                                                   :pseudo-names true}}}}}})
