# Sample App

## Description
This a project to build a composable app with clean architecture. 
The Sample app connects to some public apis to retrieve data from an external service. It has also
a feature to save the retrieved data in the local storage.

## Connected public Api
- [Age of Empires 2](https://age-of-empires-2-api.herokuapp.com/docs/#/)
  - ``/civilizations`` Gets a list of all the civilizations in AOE2
  - ``/civilization/{id}`` Gets a given civilization by ID (Integer) or name (String with spaces
    replaced with hyphens/underscores)
  - ``/units`` Gets a list of all the units in AOE2
  - ``/units/{id}`` Gets a given unit by ID (Integer) or name (String with spaces replaced with
    hyphens/underscores)
  - ``/structures`` Gets a list of all the structures in AOE2
  - ``/structures/{id}`` Gets a given structure by ID (Integer) or name (String with spaces replaced
    with hyphens/underscores)
  - ``/technologies`` Gets a list of all the technologies in AOE2
  - ``/technologies/{id}`` Gets a given technology by ID (Integer) or name (String with spaces
    replaced with hyphens/underscores)

## Dependencies

- Jetpack Compose
- Material3
- Compose Navigation
- Coil
- Retrofit2
- converter-gson

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.com/irfantemur/sample-app/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Automatically merge when pipeline succeeds](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***