(ns user
  (:require
    [hyperfiddle.rcf]
    [shadow.cljs.devtools.api :as shadow]))

(hyperfiddle.rcf/enable!)


(comment
  :cljs/quit
  (shadow/repl :app)
  (type 1)
  (println "toto "))

