(defproject clj-grep "0.1.0-SNAPSHOT"
  :description "grep implemented in clojure as coding kata"
  :url "https://github.com/strika/clj-grep"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot clj-grep.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
