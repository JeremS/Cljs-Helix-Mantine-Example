(ns app.portfolio.scenes.checkbox-scenes
  (:require
    [app.portfolio.utils :as u]
    [helix.core :as hc :refer [$]]
    [portfolio.react-18 :refer-macros [defscene]]
    ["@mantine/core" :as mt]))


(defscene mantine-checkbox
  ($ u/Provider {:defaultColorScheme "light"}
     ($ mt/Checkbox  {:defaultChecked true :label "I disagree"})))

