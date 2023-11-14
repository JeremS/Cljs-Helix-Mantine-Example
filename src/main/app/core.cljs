(ns app.core
  (:require
    [app.lib :refer [defnc]]
    [applied-science.js-interop :as j]
    [helix.core :as hc :refer [$]]
    [helix.dom :as d]
    [helix.hooks :as h]
    ["@mantine/core" :as mantine]
    ["@mantine/hooks" :as mth]
    ["react" :as react]
    ["react-dom/client" :as react-dom]))



(defnc Greater [{:as _}]
  (let [[value set-state!] (h/use-state "")]
    (d/div
      (d/input {:type "text" :value value
                :onChange (fn [e]
                            (-> e
                                .-target
                                .-value
                                set-state!))})
      ($ mantine/Button {:onClick #(set-state! "")} "reset")
      (d/p "Hello " value "!!!"))))


(defnc App []
  (j/let [^:js [opened {:keys [toggle]}]  (mth/useDisclosure)]
    ($ mantine/AppShell
      {:header #js {:height 60}
       :navbar #js {:width 100
                    :breakpoint "sm" :collapsed #js {:mobile (not opened)}}
       :padding "md"}
      ($ mantine/AppShell.Header
         ($ mantine/Burger {:opened opened :onClick toggle :hiddenFrom "sm" :size "sm"})
         (d/div "My app."))
      ($ mantine/AppShell.Navbar {:p "md"} "Navbar")
      ($ mantine/AppShell.Main
         ($ Greater)))))

(defnc Main []
  ($ mantine/MantineProvider
    ($ App)))


(defonce root (react-dom/createRoot (js/document.getElementById "root")))


(defn render
  []
  (.render root
    ($ react/StrictMode
       ($ Main))))


(defn ^:export init
  []
  (render))

(comment
  (render))

